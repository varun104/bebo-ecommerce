package com.bebo.app.ecommerce.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.bebo.app.ecommerce.constants.AppConstants.ADMIN;


@Component("auditAwareImpl")
public class AuditAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of(ADMIN);
    }
}
