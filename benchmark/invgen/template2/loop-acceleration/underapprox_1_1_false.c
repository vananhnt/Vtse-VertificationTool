
int underapprox_1_1_false() {
  int x; int y;
  x = 0;
  y = 1;

  while (x < 6) {
     invariant: (y >= 0) and (y - 1 >= 0);
    x = x + 1;
    y = 2*y;
  }
  return y;
  //__VERIFIER_assert(y != 64);
}
