package friendsofmine.repositories;

import friendsofmine.domain.Activite;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ActiviteRepository extends PagingAndSortingRepository<Activite, Long> {

    // pour la correction du 1+n select
    @Query("select activite from Activite activite join fetch activite.responsable order by activite.titre asc")
    public Iterable<Activite> findAll();
}
