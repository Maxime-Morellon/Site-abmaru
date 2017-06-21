package friendsofmine.service;

import friendsofmine.domain.Activite;
import friendsofmine.domain.Utilisateur;
import friendsofmine.repositories.ActiviteRepository;
import friendsofmine.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ActiviteService {

    @Autowired
    private ActiviteRepository activiteRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public Activite saveActivite(Activite activite) {
        if (activite == null) {
            throw new IllegalArgumentException("Activite must not be null");
        }
        Utilisateur responsable = activite.getResponsable();
        if (responsable != null) {
            utilisateurRepository.save(responsable);
            responsable.addActivite(activite);
        }
        return activiteRepository.save(activite);
    }

    public Activite findOneActivite(Long id) {
        return activiteRepository.findOne(id);
    }

    public long countActivite() {
        return activiteRepository.count();
    }

    public ArrayList<Activite> findAllActivites() {
        // Solution sans @Query dans le findAll de ActiviteRepository
        // Iterable<Activite> activites = activiteRepository.findAll(new Sort(new Sort.Order(Sort.Direction.ASC,"titre")));
        Iterable<Activite> activites = activiteRepository.findAll();
        ArrayList<Activite> activitesList = new ArrayList<>();
        activites.forEach(activitesList::add);
        return activitesList;
    }

    public ActiviteRepository getActiviteRepository() {
        return activiteRepository;
    }

    public void setActiviteRepository(ActiviteRepository activiteRepository) {
        this.activiteRepository = activiteRepository;
    }

    public UtilisateurRepository getUtilisateurRepository() {
        return utilisateurRepository;
    }

    public void setUtilisateurRepository(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

}
