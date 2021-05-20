package io.podiyumm.song;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import io.quarkus.test.junit.QuarkusTestProfile;

public class MockSongProfile  implements
        QuarkusTestProfile {

    @Override
    public Map<String, String> getConfigOverrides() {
        return Collections.singletonMap("quarkus.mongodb.migration.enabled","false");
    }

//    @Override
//    public Set<Class<?>> getEnabledAlternatives() {
//        return Collections.singleton(MockGreetingService.class);
//    }


    @Override
    public String getConfigProfile() {
        return "test";
    }

//    @Override
//    public List<TestResourceEntry> testResources() {
//        return Collections.singletonList(new TestResourceEntry(CustomWireMockServerManager.class));
//    }
}