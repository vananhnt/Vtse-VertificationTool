// Source: A. Costan, S. Gaubert, E. Goubault, M. Martel, S. Putot: "A Policy
// Iteration Algorithm for Computing Fixed Points in Static Analysis of
     invariant: +0) <= 0;
// Programs", CAV 2005

int cggmp2005_true() {
    int i;
    int j;
    i = 1;
    j = 10;
    while (j >= i) {
     invariant: +0) <= 0;
        i = i + 2;
        j = -1 + j;
    }
  //  __VERIFIER_assert(j == 6);
    return j;
}
