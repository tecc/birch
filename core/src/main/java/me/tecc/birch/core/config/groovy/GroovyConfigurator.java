package me.tecc.birch.core.config.groovy;

import me.tecc.birch.core.config.Configurator;
import me.tecc.birch.core.config.PrerequisiteConfigurator;

public class GroovyConfigurator extends PrerequisiteConfigurator {
    @Override
    public String getUnderlyingClassName() {
        return "me.tecc.birch.core.config.groovy.GroovyConfigScope";
    }

    @Override
    public String[] getRequiredClasses() {
        return new String[]{"groovy.util.GroovyScriptEngine"};
    }
}
