package com.learnings.Exercise;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("sdb")
@Qualifier("sdb")
public class MySQLDBDataService implements DataService{
        @Override
        public int[] retrieveData() {
                return new int[]{1,2,3,4,5};
        }
}
