#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.ctx;

import javax.inject.Provider;

import com.jarredweb.webjar.service.api.BasicsService;

public interface AppServices {

	Provider<BasicsService> getBasicsService();

	void setBasicsService(Provider<BasicsService> basicsService);

}