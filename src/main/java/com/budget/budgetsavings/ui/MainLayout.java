package com.budget.budgetsavings.ui;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.Layout;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.theme.lumo.LumoUtility;

@Layout("")
public class MainLayout extends AppLayout {

    public MainLayout() {
        H1 title = new H1("Budget Savings");
        addToNavbar(title);
        DrawerToggle toggle = new DrawerToggle();

        Button logoutButton = new Button("Logout", event -> {
            VaadinSession.getCurrent().setAttribute("user", null);
            VaadinSession.getCurrent().close();
            UI.getCurrent().navigate("login");
        });
        logoutButton.getElement().getStyle().set("margin-left", "auto");
        SideNav nav = getSideNav();

        Scroller scroller = new Scroller(nav);
        scroller.setClassName(LumoUtility.Padding.SMALL);

        addToDrawer(scroller);
        addToNavbar(toggle, title, logoutButton);
        setPrimarySection(Section.DRAWER);

    }

    private SideNav getSideNav() {
        SideNav nav = new SideNav();
        nav.addItem(
                new SideNavItem("Dashboard", "/dashboard",
                        VaadinIcon.DASHBOARD.create()),
                new SideNavItem("Accounts", "/accounts", VaadinIcon.DOLLAR.create()));
        return nav;
    }

}
