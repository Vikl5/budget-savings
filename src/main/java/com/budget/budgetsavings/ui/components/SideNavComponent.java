package com.budget.budgetsavings.ui.components;

import com.budget.budgetsavings.ui.MainLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;

public class SideNavComponent extends Div {

    public SideNavComponent() {
        SideNav nav = new SideNav();

        SideNavItem dashboardLink = new SideNavItem("Dashboard",
                MainLayout.class, VaadinIcon.DASHBOARD.create());

        nav.addItem(dashboardLink);

        Div navWrapper = new Div(nav);
        nav.setWidthFull();
        add(navWrapper);

    }
}
