package br.com.learn.hexagonal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.learn.hexagonal.adapters.out.DeleteCustomerByIdAdapter;
import br.com.learn.hexagonal.application.core.usecase.DeleteCustomerByIdUsecCase;
import br.com.learn.hexagonal.application.core.usecase.FindCustomerByIdUseCase;

@Configuration
public class DeleteCustomerByIdUserCaseConfig {

    @Bean
    public DeleteCustomerByIdUsecCase deleteCustomerByIdUserCase(DeleteCustomerByIdAdapter deleteCustomerByIdAdapter,
            FindCustomerByIdUseCase findCustomerByIdUseCase) {
        return new DeleteCustomerByIdUsecCase(deleteCustomerByIdAdapter, findCustomerByIdUseCase);
    }
}
