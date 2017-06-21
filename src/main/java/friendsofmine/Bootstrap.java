package friendsofmine;

import friendsofmine.service.InitialisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Bootstrap {

    @Autowired
    private InitialisationService initialisationService;

    @PostConstruct
    public void init() {
        try {
            initialisationService.initDonnees();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public InitialisationService getInitialisationService() {
        return initialisationService;
    }

    public void setInitialisationService(InitialisationService initialisationService) {
        this.initialisationService = initialisationService;
    }
}
