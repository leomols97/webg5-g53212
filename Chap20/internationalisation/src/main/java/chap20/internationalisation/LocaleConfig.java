package chap20.internationalisation;

Configuration
public class LocaleConfig implements WebMvcConfigurer {
@Bean
public LocaleResolver localeResolver() {
return new SessionLocaleResolver(); }
@Override
public void addInterceptors(InterceptorRegistry registry) {
LocaleChangeInterceptor lci = new LocaleChangeInterceptor(); lci.setParamName("lang");
registry.addInterceptor(lci);
}
}