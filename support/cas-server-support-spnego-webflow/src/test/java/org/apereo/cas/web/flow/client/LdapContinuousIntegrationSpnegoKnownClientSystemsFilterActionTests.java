package org.apereo.cas.web.flow.client;

import com.unboundid.ldap.sdk.LDAPConnection;
import lombok.extern.slf4j.Slf4j;
import org.apereo.cas.adaptors.ldap.LdapIntegrationTestsOperations;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.test.context.TestPropertySource;

/**
 * Test cases for {@link LdapSpnegoKnownClientSystemsFilterAction}.
 *
 * @author Misagh Moayyed
 * @since 4.1
 */
@TestPropertySource(locations = {"classpath:/spnego.properties", "classpath:/spnego-ldap-ci.properties"})
@Slf4j
public class LdapContinuousIntegrationSpnegoKnownClientSystemsFilterActionTests
    extends BaseLdapSpnegoKnownClientSystemsFilterActionTests {

    @Before
    public void setup() {
        LdapIntegrationTestsOperations.checkContinuousIntegrationBuild(true);
    }

    @BeforeClass
    public static void bootstrap() throws Exception {
        LdapIntegrationTestsOperations.checkContinuousIntegrationBuild(true);
        final LDAPConnection c = new LDAPConnection("localhost", 10389,
            "cn=Directory Manager", "password");
        LdapIntegrationTestsOperations.populateDefaultEntries(c, "ou=people,dc=example,dc=org");
    }
}