package me.destro.swagger.codegen.kotlin.helpers;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;
import io.swagger.codegen.v3.CodegenParameter;

import java.io.IOException;

import static org.apache.commons.lang3.Validate.notNull;

public enum Retrofit2Helpers implements Helper<CodegenParameter> {
    annotation {
        @Override
        protected CharSequence safeApply(CodegenParameter context, Options options) {
            if (context.getIsBodyParam()) {
                return "@Body";
            }else if (context.getIsHeaderParam()) {
                return new Handlebars.SafeString(String.format("@Header(\"%s\")", context.baseName));
            }else if (context.getIsPathParam()) {
                return new Handlebars.SafeString(String.format("@Path(\"%s\")", context.baseName));
            }else if (context.getIsQueryParam()) {
                return new Handlebars.SafeString(String.format("@Query(\"\")", context.baseName));
            }else {
                return "";
            }
        }
    };

    @Override
    public Object apply(final CodegenParameter context, final Options options) throws IOException {
        if (options.isFalsy(context)) {
            Object param = options.param(0, null);
            return param == null ? null : param.toString();
        }
        return safeApply(context, options);
    }

    protected abstract CharSequence safeApply(final CodegenParameter context, final Options options);

    /**
     * Register the helper in a handlebars instance.
     *
     * @param handlebars A handlebars object. Required.
     */
    public void registerHelper(final Handlebars handlebars) {
        notNull(handlebars, "The handlebars is required.");
        handlebars.registerHelper(name(), this);
    }
}