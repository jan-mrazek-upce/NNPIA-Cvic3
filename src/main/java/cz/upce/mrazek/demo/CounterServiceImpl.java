package cz.upce.mrazek.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service
@Scope(value="singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CounterServiceImpl implements CounterService {

    private int counter = 0;

    @Override
    public void add(){
        counter++;
    }

    @Override
    public Object getCounter() {
        return  counter;
    }
}
