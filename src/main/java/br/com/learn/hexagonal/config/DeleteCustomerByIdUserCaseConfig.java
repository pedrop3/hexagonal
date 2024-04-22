package br.com.learn.hexagonal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.learn.hexagonal.adapters.out.DeleteCustomerByIdAdapter;
import br.com.learn.hexagonal.application.core.usercase.DeleteCustomerByIdUsecCase;
import br.com.learn.hexagonal.application.core.usercase.FindCustomerByIdUseCase;

@Configuration
public class DeleteCustomerByIdUserCaseConfig {

    @Bean
    public DeleteCustomerByIdUsecCase deleteCustomerByIdUserCase(DeleteCustomerByIdAdapter deleteCustomerByIdAdapter,
            FindCustomerByIdUseCase findCustomerByIdUseCase) {
        return new DeleteCustomerByIdUsecCase(deleteCustomerByIdAdapter, findCustomerByIdUseCase);
    }
}
