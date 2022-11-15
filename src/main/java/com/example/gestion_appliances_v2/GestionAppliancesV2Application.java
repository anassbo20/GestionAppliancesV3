package com.example.gestion_appliances_v2;

import com.example.gestion_appliances_v2.bean.Chercheur;
import com.example.gestion_appliances_v2.security.bean.Permission;
import com.example.gestion_appliances_v2.security.bean.Role;
import com.example.gestion_appliances_v2.security.bean.User;
import com.example.gestion_appliances_v2.security.common.AuthoritiesConstants;
import com.example.gestion_appliances_v2.security.service.facade.RoleService;
import com.example.gestion_appliances_v2.security.service.facade.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class GestionAppliancesV2Application {

    public static ConfigurableApplicationContext ctx;

    public static void main(String[] args) {
        ctx = SpringApplication.run(GestionAppliancesV2Application.class, args);
    }

    public static ConfigurableApplicationContext getCtx() {
        return ctx;
    }

    @Bean
    public CommandLineRunner demo(UserService userService, RoleService roleService
    ) {
        return (args) -> {
            if (true) {
                Map<String, String> etats = new HashMap<>();
                etats.put("Initialisé", "initialise");
                etats.put("En cours", "encours");
                etats.put("Terminé", "termine");


                // Role admin
                User userForAdmin = new User("admin");

                Role roleForAdmin = new Role();
                roleForAdmin.setAuthority(AuthoritiesConstants.ADMIN);
                List<Permission> permissionsForAdmin = new ArrayList<>();
                addPermissionForAdmin(permissionsForAdmin);
                roleForAdmin.setPermissions(permissionsForAdmin);
                if (userForAdmin.getRoles() == null)
                    userForAdmin.setRoles(new ArrayList<>());

                userForAdmin.getRoles().add(roleForAdmin);
                userService.save(userForAdmin);

                //Role Manager
                User userForManager = new User("manager");

                Role roleForManager = new Role();
                roleForManager.setAuthority(AuthoritiesConstants.MANAGER);
                List<Permission> permissionsForManager = new ArrayList<>();
                addPermissionForManager(permissionsForManager);
                roleForManager.setPermissions(permissionsForManager);
                if (userForManager.getRoles() == null)
                    userForManager.setRoles(new ArrayList<>());

                userForManager.getRoles().add(roleForManager);
                userService.save(userForManager);

                // Role chercheur
                Chercheur userForChercheur = new Chercheur("chercheur");

                Role roleForChercheur = new Role();
                roleForChercheur.setAuthority(AuthoritiesConstants.CHERCHEUR);
                List<Permission> permissionsForChercheur = new ArrayList<>();
                addPermissionForChercheur(permissionsForChercheur);
                roleForChercheur.setPermissions(permissionsForChercheur);
                if (userForChercheur.getRoles() == null)
                    userForChercheur.setRoles(new ArrayList<>());

                userForChercheur.getRoles().add(roleForChercheur);
                userService.save(userForChercheur);
            }
        };
    }

    private static void addPermissionForAdmin(List<Permission> permissions) {

        permissions.add(new Permission("Appliance.edit"));
        permissions.add(new Permission("Appliance.list"));
        permissions.add(new Permission("Appliance.view"));
        permissions.add(new Permission("Appliance.add"));
        permissions.add(new Permission("Appliance.delete"));
        permissions.add(new Permission("Client.edit"));
        permissions.add(new Permission("Client.list"));
        permissions.add(new Permission("Client.view"));
        permissions.add(new Permission("Client.add"));
        permissions.add(new Permission("Client.delete"));
        permissions.add(new Permission("ApplianceTag.edit"));
        permissions.add(new Permission("ApplianceTag.list"));
        permissions.add(new Permission("ApplianceTag.view"));
        permissions.add(new Permission("ApplianceTag.add"));
        permissions.add(new Permission("ApplianceTag.delete"));
        permissions.add(new Permission("Contact.edit"));
        permissions.add(new Permission("Contact.list"));
        permissions.add(new Permission("Contact.view"));
        permissions.add(new Permission("Contact.add"));
        permissions.add(new Permission("Contact.delete"));
        permissions.add(new Permission("Pov.edit"));
        permissions.add(new Permission("Pov.list"));
        permissions.add(new Permission("Pov.view"));
        permissions.add(new Permission("Pov.add"));
        permissions.add(new Permission("Pov.delete"));
        permissions.add(new Permission("Sceance.edit"));
        permissions.add(new Permission("Sceance.list"));
        permissions.add(new Permission("Sceance.view"));
        permissions.add(new Permission("Sceance.add"));
        permissions.add(new Permission("Sceance.delete"));
        permissions.add(new Permission("Tag.edit"));
        permissions.add(new Permission("Tag.list"));
        permissions.add(new Permission("Tag.view"));
        permissions.add(new Permission("Tag.add"));
        permissions.add(new Permission("Tag.delete"));
        permissions.add(new Permission("Chercheur.edit"));
        permissions.add(new Permission("Chercheur.list"));
        permissions.add(new Permission("Chercheur.view"));
        permissions.add(new Permission("Chercheur.add"));
        permissions.add(new Permission("Chercheur.delete"));
        permissions.add(new Permission("Suivi.edit"));
        permissions.add(new Permission("Suivi.list"));
        permissions.add(new Permission("Suivi.view"));
        permissions.add(new Permission("Suivi.add"));
        permissions.add(new Permission("Suivi.delete"));
        permissions.add(new Permission("TypeAppliance.edit"));
        permissions.add(new Permission("TypeAppliance.list"));
        permissions.add(new Permission("TypeAppliance.view"));
        permissions.add(new Permission("TypeAppliance.add"));
        permissions.add(new Permission("TypeAppliance.delete"));
        permissions.add(new Permission("TypePrestation.edit"));
        permissions.add(new Permission("TypePrestation.list"));
        permissions.add(new Permission("TypePrestation.view"));
        permissions.add(new Permission("TypePrestation.add"));
        permissions.add(new Permission("TypePrestation.delete"));

    }

    private static void addPermissionForChercheur(List<Permission> permissions) {

        permissions.add(new Permission("Appliance.list"));
        permissions.add(new Permission("Appliance.view"));

    }

    private static void addPermissionForManager(List<Permission> permissions) {
        permissions.add(new Permission("Appliance.view"));
        permissions.add(new Permission("Appliance.list"));
        permissions.add(new Permission("Client.view"));
        permissions.add(new Permission("Client.list"));
        permissions.add(new Permission("Pov.edit"));
        permissions.add(new Permission("Pov.list"));
        permissions.add(new Permission("Pov.view"));
        permissions.add(new Permission("Pov.add"));
        permissions.add(new Permission("Sceance.edit"));
        permissions.add(new Permission("Sceance.list"));
        permissions.add(new Permission("Sceance.view"));
        permissions.add(new Permission("Sceance.add"));
        permissions.add(new Permission("Suivi.edit"));
        permissions.add(new Permission("Suivi.list"));
        permissions.add(new Permission("Suivi.view"));
        permissions.add(new Permission("Suivi.add"));
        permissions.add(new Permission("TypeAppliance.view"));
        permissions.add(new Permission("TypeAppliance.list"));
        permissions.add(new Permission("TypePrestation.view"));
        permissions.add(new Permission("TypePrestation.list"));
        permissions.add(new Permission("Contact.view"));
        permissions.add(new Permission("Contact.list"));

    }

}
