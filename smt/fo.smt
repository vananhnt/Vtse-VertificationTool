(declare-fun flag_fo_0 () Int)
(declare-fun n_fo_0 () Int)
(declare-fun k_fo_0 () Int)
(declare-fun k_fo_1 () Int)
(declare-fun k_fo_2 () Int)
(declare-fun i_fo_0 () Int)
(declare-fun i_fo_1 () Int)
(declare-fun i_fo_2 () Int)
(declare-fun i_fo_3 () Int)
(declare-fun j_fo_0 () Int)
(declare-fun j_fo_1 () Int)
(declare-fun j_fo_2 () Int)
(declare-fun j_fo_3 () Int)
(declare-fun z_fo_0 () Int)
(declare-fun z_fo_1 () Int)
(declare-fun return_fo_0 () Int)
(assert (and (and (and (and (and (and (= k_fo_1 1) (and (=> (> flag_fo_0 0) (= k_fo_2 (* n_fo_0 n_fo_0))) (=> (not (> flag_fo_0 0)) (= k_fo_2 k_fo_1)))) (= i_fo_1 0)) (= j_fo_1 0)) (and (=> (<= i_fo_1 n_fo_0) (and (and (= i_fo_2 (+ i_fo_1 1)) (= j_fo_2 (+ j_fo_1 i_fo_2))) (and (=> (<= i_fo_2 n_fo_0) (and (= i_fo_3 (+ i_fo_2 1)) (= j_fo_3 (+ j_fo_2 i_fo_3)))) (=> (not (<= i_fo_2 n_fo_0)) (and (= i_fo_3 i_fo_2) (= j_fo_3 j_fo_2)))))) (=> (not (<= i_fo_1 n_fo_0)) (and (= i_fo_3 i_fo_1) (= j_fo_3 j_fo_1))))) (= z_fo_1 (+ (+ k_fo_2 i_fo_3) j_fo_3))) (= return_fo_0 z_fo_1)))
(assert (not ))
(check-sat)
(get-model)