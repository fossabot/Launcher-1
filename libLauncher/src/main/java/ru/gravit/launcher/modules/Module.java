package ru.gravit.launcher.modules;

import ru.gravit.launcher.LauncherVersion;

public interface Module extends AutoCloseable {

    String getName();

    LauncherVersion getVersion();

    int getPriority();
    void init(ModuleContext context);
  
    void postInit(ModuleContext context);
    
    void preInit(ModuleContext context);
}