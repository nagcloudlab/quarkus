package io.quarkus.workshop.superheroes.banner.deployment;
public final class BannerConfig$$accessor {
    private BannerConfig$$accessor() {}
    @SuppressWarnings("unchecked")
    public static Object get_path(Object __instance) {
        return ((BannerConfig)__instance).path;
    }
    @SuppressWarnings("unchecked")
    public static void set_path(Object __instance, Object path) {
        ((BannerConfig)__instance).path = (String)path;
    }
    public static Object construct() {
        return new BannerConfig();
    }
}
