if __name__ == "__main__":
    n_nodes = int(input())
    colors = input().split(' ')
    parents = input().split(' ')
    
    n_good_white = 0
    n_good_black = 0
    
    has_child = [False for _ in range(n_nodes)]
    n_reverse_children = dict()
    n_black_node_children = dict()

    for nid, p in enumerate(parents):
        pid = int(p) - 1
        if pid < 0:
            continue
        p_color = colors[pid]
        n_color = colors[nid]
        
        if n_color != p_color:
            n_reverse_children[pid] = n_reverse_children.get(pid, 0) + 1
        
        if p_color == '1':
            n_black_node_children[pid] = n_black_node_children.get(pid, 0) + 1
        
        has_child[pid] = True
    
    for nid in range(n_nodes):
        n_color = colors[nid]
        if n_color == '0':
            if not has_child[nid] or n_reverse_children.get(nid, 0) > 0:
                n_good_white += 1
        else:
            if n_reverse_children.get(nid, 0) == n_black_node_children.get(nid, 0):
                n_good_black += 1
    
    print(n_good_white, n_good_black)
