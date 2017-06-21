package friendsofmine.service;

import friendsofmine.domain.Utilisateur;
import friendsofmine.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository ;

    public Utilisateur saveUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur) ;
    }

    public Utilisateur findOneUtilisateur(Long id) {
        return utilisateurRepository.findOne(id);
    }

    public long countUtilisateur() {
        return utilisateurRepository.count();
    }

    public void deleteUtilisateur(Long id) {
        this.utilisateurRepository.delete(id);
    }

    public ArrayList<Utilisateur> findAllUtilisateurs() {
        Iterable<Utilisateur> utilisateurs = utilisateurRepository.findAll(new Sort(new Sort.Order(Sort.Direction.ASC,"nom")));
        ArrayList<Utilisateur> utilisateurList = new ArrayList<>();
        utilisateurs.forEach(utilisateurList::add);
        return utilisateurList;
    }

    public UtilisateurRepository getUtilisateurRepository() {
        return utilisateurRepository;
    }

    public void setUtilisateurRepository(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }
}
