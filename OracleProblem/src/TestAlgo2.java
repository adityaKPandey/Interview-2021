/* IMPORTANT: class must not be public. */

/*
 * uncomment this if you want to read input.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


class TestAlgo2 {
	public static void main(String args[] ) throws Exception {
		/*
		 * Read input from stdin and provide input before running
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int n = Integer.parseInt(line);
		//create adjacency list
		Map<Integer,Set<Integer>> nodeToConnected = new HashMap<>();

		for (int i = 0; i < n-1; i++) {
			line = br.readLine();
			String [] arr = line.split(" ");
			Integer key = Integer.parseInt(arr[0]);
			Integer connected = Integer.parseInt(arr[1]) ;
			if(!nodeToConnected.containsKey(key))
				nodeToConnected.put(key , new HashSet<Integer>());

			nodeToConnected.get(key).add(connected);
			

			if(!nodeToConnected.containsKey(connected))
				nodeToConnected.put(connected , new HashSet<Integer>());

			nodeToConnected.get(connected).add(key);


		}

		Map<Integer,Integer>nodeToColor = new HashMap<>();
		Map<Integer,Set<Integer>>colorToNodes = new HashMap<>();

		int colors = 0 , maxColor = 0;//starts 1
		//iterate adjacency list to get colors needed.Pick min of all
		Integer node = nodeToConnected.keySet().iterator().next();
		List<Integer>newNodes = new LinkedList<>();
		newNodes.add(node);
		int lastIndex = -1;
		while(newNodes.size() < n ){


			/*
        		  1. Start from first node .
        		  2. Assign it a color.
        		  3. Assign different colors to its connected nodes
        		  4. Go to each connected node and find color which is not assigned to its neighbors
        		  5. 

			 */
			node = newNodes.get(++lastIndex);
			if(colors == 0) {
				colors++;
				nodeToColor.put(node, ++maxColor);
				colorToNodes.put(maxColor, new HashSet<>());
				colorToNodes.get(maxColor).add(node);
				 
			}

			Set<Integer> connectedNodes = nodeToConnected.get(node);
			
			for(Integer cn : connectedNodes) {
				if(nodeToColor.containsKey(cn))
					continue;
				
				// node -> cn
				// setOfColors = colorToNodes.keySet()
				// neighbours of cn + neighbour of neighbour of cn
				Set<Integer>setOfNeighbours = new HashSet<>();
				Set<Integer>setOfNeighbours1 = new HashSet<>();
				setOfNeighbours1.addAll(nodeToConnected.get(cn));
				 
				setOfNeighbours1.forEach((c) -> setOfNeighbours.addAll( nodeToConnected.get(c)));
				setOfNeighbours.addAll(setOfNeighbours1);
				
				int idealCol = findIdealColor(new HashSet<>(colorToNodes.keySet()) , setOfNeighbours , nodeToColor);
				if(idealCol > maxColor)
					maxColor = idealCol;
				
				nodeToColor.put(cn, idealCol);
				colorToNodes.put(idealCol, new HashSet<>());
				colorToNodes.get(idealCol).add(cn);
				
				newNodes.add(cn);

			}

		}


		System.out.println("Max color:"+maxColor);
	}

	private static int findIdealColor( Set<Integer> colors, Set<Integer> setOfNeighbours ,
			Map<Integer,Integer>nodeToColor) {
		int size = colors.size();
		for(Integer node:setOfNeighbours) {
			colors.remove(nodeToColor.get(node));
		}
		
		if(colors.isEmpty())
		  return size+1;
		
		return colors.iterator().next();
	}
}