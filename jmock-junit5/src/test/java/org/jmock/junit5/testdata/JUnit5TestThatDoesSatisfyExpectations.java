package org.jmock.junit5.testdata;

import org.jmock.Expectations;
import org.jmock.junit5.JUnit5Mockery;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

public class JUnit5TestThatDoesSatisfyExpectations {
    @RegisterExtension
    private JUnit5Mockery context = new JUnit5Mockery();
    private Runnable runnable = context.mock(Runnable.class);
    
    @Test
    public void doesSatisfyExpectations() {
        context.checking(new Expectations() {{
            oneOf (runnable).run();
        }});
        
        runnable.run();
    }
}
