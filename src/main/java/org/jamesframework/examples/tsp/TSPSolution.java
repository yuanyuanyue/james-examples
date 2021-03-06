/*
 * Copyright 2014 Ghent University, Bayer CropScience.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jamesframework.examples.tsp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.jamesframework.core.problems.sol.Solution;

/**
 * Represent a solution to the travelling salesman problem.
 * Each city is represented by a unique integer value, corresponding
 * to the row and column indices in the travel distance matrix.
 * 
 * @author <a href="mailto:herman.debeukelaer@ugent.be">Herman De Beukelaer</a>
 */
public class TSPSolution extends Solution {

    // list of cities in the order in which they are visited
    private List<Integer> cities;
    
    public TSPSolution(List<Integer> cities){
        this.cities = cities;
    }
    
    public List<Integer> getCities(){
        return cities;
    }
    
    // swap the i-th and j-th city in the round trip
    public void swapCities(int i, int j){
        Collections.swap(cities, i, j);
    }
    
    @Override
    public TSPSolution copy() {
        return new TSPSolution(new ArrayList<>(cities));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TSPSolution other = (TSPSolution) obj;
        return Objects.equals(this.cities, other.cities);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cities);
    }

}
