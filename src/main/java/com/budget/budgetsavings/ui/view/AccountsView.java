package com.budget.budgetsavings.ui.view;

import com.budget.budgetsavings.domain.Accounts;
import com.budget.budgetsavings.domain.AccountsRepository;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("accounts")
public class AccountsView extends VerticalLayout {

    public AccountsView(@Autowired AccountsRepository accountsRepository) {

        Grid<Accounts> grid = new Grid<>(Accounts.class);
        grid.setItems(accountsRepository.findAll());
        grid.setColumns("accountId", "accountNumber", "accountType", "balance", "currency", "owner");

        add(grid);
    }
}
