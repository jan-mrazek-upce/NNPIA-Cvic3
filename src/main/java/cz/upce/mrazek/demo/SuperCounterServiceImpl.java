package cz.upce.mrazek.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service
@Scope(value="session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SuperCounterServiceImpl implements CounterService {

    private int counter = 1;

    @Override
    public void add(){
        counter*=2;
    }

    @Override
    public Object getCounter() {
        return  counter;
    }
}
