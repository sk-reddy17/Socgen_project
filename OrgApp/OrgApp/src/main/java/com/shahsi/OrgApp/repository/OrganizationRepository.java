package com.shahsi.OrgApp.repository;

import com.shahsi.OrgApp.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization , Integer> {
    Organization findByOrgId(String orgId);
}
