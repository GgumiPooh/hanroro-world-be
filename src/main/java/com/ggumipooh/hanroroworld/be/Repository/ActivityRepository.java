package com.ggumipooh.hanroroworld.be.Repository;

import com.ggumipooh.hanroroworld.be.model.activity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
