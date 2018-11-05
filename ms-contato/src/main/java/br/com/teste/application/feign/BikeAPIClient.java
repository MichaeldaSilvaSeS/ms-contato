package br.com.teste.application.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(name="phoneApi",url="http://api.citybik.es",path="/v2")
public interface BikeAPIClient {

	@RequestMapping(method=RequestMethod.GET, value = {"/networks/{network_id}"}, produces={MediaType.APPLICATION_JSON_UTF8_VALUE},headers= {"session","cookie","accept","pragma:no-cache","cache-control:no-cache"})
	public @ResponseBody String getBikes(@RequestParam("network_id") String network_id);
}
