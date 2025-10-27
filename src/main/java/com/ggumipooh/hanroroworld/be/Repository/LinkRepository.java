package com.ggumipooh.hanroroworld.be.Repository;

import com.ggumipooh.hanroroworld.be.model.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkRepository extends JpaRepository<Link, Long> {
}
