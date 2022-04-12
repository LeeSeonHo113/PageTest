package site.metacoding.pagetest.openapi.contents.field;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentsFieldRepository extends JpaRepository<ContentsField, Integer> {

}