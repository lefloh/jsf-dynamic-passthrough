package de.utkast.playground.passthrough;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named
@RequestScoped
public class MyController {

	private static final Logger LOG = LoggerFactory.getLogger(MyController.class);
	
	@Inject
	private MyModel myModel;
	
	public void doSomething(AjaxBehaviorEvent event) {
		LOG.info("doSomething: " + FacesContext.getCurrentInstance().getCurrentPhaseId());
		myModel.setMobileRequired(StringUtils.isBlank(myModel.getTelephone()));
	}
	
	public Map<String, Object> getPassThroughAttributesForMobile() {
		LOG.info("getPassThroughAttributesForMobile: " + FacesContext.getCurrentInstance().getCurrentPhaseId());
		Map<String, Object> map = new HashMap<String, Object>(1);
		if (myModel.isMobileRequired()) {
			map.put("required", "required");
		}
		return map;
	}
}
