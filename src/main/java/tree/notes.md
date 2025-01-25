(1) A tree is an undirected graph in which any two vertices are
connected by exactly one path.

(2) Any connected graph who has n nodes with n-1 edges is a tree.

(3) The degree of a vertex of a graph is the number of
edges incident to the vertex.

(4) A leaf is a vertex of degree 1. An internal vertex is a vertex of
degree at least 2.

(5) A path graph is a tree with two or more vertices that is not
branched at all.

(6) A tree is called a rooted tree if one vertex has been designated
the root.

(7) The height of a rooted tree is the number of edges on the longest
downward path between root and a leaf.

1. ## Proper/Full/Strict Binary Tree :
        
    For every node, either 0 or 2 children.

2. ## Complete Binary Tree : 
   
    A complete binary is a binary tree in which every level of the tree is completely filled,
    except for perhaps the last level. To the extent that the last level is filled,
    it is filled left to right.

3. ## Perfect Binary Tree:

    A perfect binary tree is one that is both full and complete. All leaf nodes will be 
    at the same level, and this level has maximum number of nodes.
   
## Height of binary tree 
    Log(N+1) - 1  to the base 2

## Tries
![trie.drawio.png](..%2F..%2F..%2FDownloads%2Ftrie.drawio.png)
    1. Known as prefix-tree
    2. Called as N-Children tree
    3. It is used for information retrieval
    4. Trie is a Data Structure stores the information 
       from top to bottom. 
    5. There should an extra marker to denote whether the 
        current node is denoting the end of the word or not.
