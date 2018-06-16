stableMariage(L) :-

L= [F1, F2, F3],

fd_domain(L, 1, 3),


%mandatory_relationships
Root #= F1,
F1 #= F6,
F4 #= F8,

%optional_relationships
F1 #>= F6,
F4 #>= F9,
F3 #>= F7,

%group_cardinality
Root #>= F2,
Root #>= F3,
Root #>= F4,
Root #=< F2 + F3 + F4,
F2+ F3+ F4 #=< Root,


%mutex
F3 * F8 #= 0,
F3 * F5 #= 0,

%requires
F7 #>= F8,
F8 #==> F7,
F9 #>= F5,
F5 #==> F9,

fd_labeling(L).