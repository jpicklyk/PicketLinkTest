/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.rim.cso.picketlinktest;

import java.util.Properties;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import net.rim.cso.picketlinktest.model.AttributeReferenceTypeEntity;
import net.rim.cso.picketlinktest.model.AttributeTypeEntity;
import net.rim.cso.picketlinktest.model.IdentityTypeEntity;
import net.rim.cso.picketlinktest.model.LdapUser;
import net.rim.cso.picketlinktest.model.PartitionTypeEntity;
import net.rim.cso.picketlinktest.model.RelationshipIdentityTypeReferenceEntity;
import net.rim.cso.picketlinktest.model.RelationshipTypeEntity;
import net.rim.cso.picketlinktest.model.RoleTypeEntity;

import org.picketlink.idm.config.IdentityConfiguration;
import org.picketlink.idm.config.IdentityConfigurationBuilder;
import org.picketlink.idm.model.Partition;
import org.picketlink.idm.model.Relationship;
import org.picketlink.idm.model.basic.Group;
import org.picketlink.idm.model.basic.Role;
import org.picketlink.internal.EEJPAContextInitializer;

/**
 * 
 * @author jpicklyk
 */
@ApplicationScoped
public class IDMConfiguration {
	private final String PROPERTIES_FILENAME = "ldap-settings.properties";
	@Inject
	private EEJPAContextInitializer contextInitializer;

	private Properties ldapSettings;

	/**
	 * <p>
	 * We use this method to produce a {@link IdentityConfiguration} configured
	 * with a LDAP store.
	 * </p>
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Produces
	public IdentityConfiguration configure() {
		buildProperties();
		IdentityConfigurationBuilder builder = new IdentityConfigurationBuilder();
		builder.named("default")
				.stores()
				.jpa()
				.mappedEntity(RelationshipTypeEntity.class,
						RelationshipIdentityTypeReferenceEntity.class,
						RoleTypeEntity.class,
						AttributeReferenceTypeEntity.class,
						PartitionTypeEntity.class, AttributeTypeEntity.class,
						IdentityTypeEntity.class)
				.addContextInitializer(contextInitializer)
				.supportGlobalRelationship(Relationship.class)
				.supportType(Role.class, Partition.class)
				.supportAttributes(true).ldap()
				.baseDN(ldapSettings.getProperty("baseDN"))
				.bindDN(ldapSettings.getProperty("bindAccount"))
				.bindCredential(ldapSettings.getProperty("bindPassword"))
				.url(ldapSettings.getProperty("ldapURL")).activeDirectory(true)
				.supportCredentials(true)
				.supportType(LdapUser.class, Group.class)
				.addCredentialHandler(LdapUserCredentialHandler.class)
				.mapping(LdapUser.class)
				.baseDN(ldapSettings.getProperty("userDN"))
				.objectClasses("person", "organizationalPerson", "user")
				.attribute("loginName", "sAMAccountName")
				.attribute("firstName", "givenName")
				.attribute("lastName", "sn").attribute("email", "mail")
				.attribute("fullName", "cn", true)
				.readOnlyAttribute("createdDate", "whenCreated")
				.mapping(Group.class)
				.baseDN(ldapSettings.getProperty("groupDN"))
				.objectClasses("group").attribute("name", "cn", true)
				.readOnlyAttribute("createdDate", "whenCreated");

		return builder.build();
	}

	private void buildProperties() {
		if (this.ldapSettings == null) {
			ldapSettings = new Properties();

			// ldapSettings.load(initialContext.getResourceAsStream("/WEB-INF/"+
			// PROPERTIES_FILENAME));
			ldapSettings.put("baseDN", "");
			ldapSettings.put("bindAccount", "");
			ldapSettings.put("bindPassword", "");
			ldapSettings.put("ldapURL", "");
			ldapSettings.put("userDN", "");
			ldapSettings.put("groupDN", "");

		}
	}
}
