package fci.sw2.project.vote;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface VoteRepository extends CrudRepository<Vote ,Key> {

}
