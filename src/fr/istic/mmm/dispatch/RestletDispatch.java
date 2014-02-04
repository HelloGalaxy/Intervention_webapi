package fr.istic.mmm.dispatch;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

import fr.istic.mmm.domain.internalservice.LogController;
import fr.istic.mmm.domain.logexecution.LogExecutor;
import fr.istic.mmm.domain.webapi.AccountController;
import fr.istic.mmm.domain.webapi.InterventionController;
import fr.istic.mmm.domain.webapi.LoginController;
import fr.istic.mmm.domain.webapi.SynInterventionController;
import fr.istic.mmm.domain.webapi.TestController_Intervention;
import fr.istic.mmm.domain.webapi.TestController_User;
import fr.istic.mmm.domain.webapi.UserController;

@SuppressWarnings("deprecation")
public class RestletDispatch extends Application {

	@Override
	public synchronized Restlet createInboundRoot() {
		final Router router = new Router(getContext());

		// TODO: DEV
		router.attach("/test", TestController_User.class);
		router.attach("/test/id/{id}", TestController_User.class);
		router.attach("/test_intervention", TestController_Intervention.class);
		router.attach("/test_intervention/id/{id}",
				TestController_Intervention.class);
		router.attach("/test_intervention/id/{id}/ivid/{ivid}",
				TestController_Intervention.class);

		// SERVICE DISPATCH
		router.attach("/user", UserController.class);
		router.attach("/user/{userid}", UserController.class);

		router.attach("/log", LogController.class);

		router.attach("/login/{login}/{password}", LoginController.class);

		router.attach("/intervention/syn/{userid}",
				SynInterventionController.class);

		router.attach("/account", AccountController.class);
		router.attach("/account/{userid}", AccountController.class);
		router.attach("/account/{userid}/{accountid}", AccountController.class);

		router.attach("/intervention", InterventionController.class);
		router.attach("/intervention/{userid}", InterventionController.class);
		router.attach("/intervention/{userid}/{interventionid}",
				InterventionController.class);

		return router;
	}
}