package friendsofmine.repositories;

import friendsofmine.domain.Utilisateur;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UtilisateurRepository extends PagingAndSortingRepository<Utilisateur, Long> {

}
