import java.util.*;

/**
 * 6 Degrees of Kevin Bacon!
 **/
class SixDegreesOfKevinBacon {

    public static int find_bacon_number(String actorName, Map<String, Set<String>> graph){
        Queue<Pair> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.add(new Pair(actorName, 0));
        visited.add(actorName);

        while(!q.isEmpty()){
            Pair current = q.poll();
            if(current.actor.equals("Kevin Bacon")){
                return current.distance;
            }

            for(String neighbor : graph.get(current.actor)){
                if(!visited.contains(neighbor)){
                    visited.add(neighbor);
                    q.add(new Pair(neighbor, current.distance + 1));
                }
            }
            
        }

        return-1;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String actorName = in.nextLine();
        int n = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }

        Map<String, Set<String>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String movieCast = in.nextLine();
            // Split the movie name and the cast
            String[] parts = movieCast.split(": ");
            String[] actors = parts[1].split(", ");

            // Add edges between all pairs of actors in the cast
            for (String actor : actors) {
                graph.putIfAbsent(actor, new HashSet<>());
                for (String coActor : actors) {
                    if (!actor.equals(coActor)) {
                        graph.get(actor).add(coActor);
                        graph.putIfAbsent(coActor, new HashSet<>());
                        graph.get(coActor).add(actor);
                    }
                }
            }
        }

        int bacon_number = find_bacon_number(actorName, graph);
        System.out.println(bacon_number);
    }

    public static class Pair{
        String actor;
        int distance;
        Pair(String actor, int distance){
            this.actor = actor;
            this.distance = distance;
        }
    }

}