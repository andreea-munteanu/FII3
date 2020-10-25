"""
TEST 1 - TRUE
constraints = [('WA', 'SA'), ('WA', 'NT'), ('SA', 'WA'), ('SA', 'NT'), ('NT', 'WA'), ('NT', 'SA')]
domain = {'WA': ['R', 'G', 'B'], 'SA': ['R', 'G'], 'NT': ['G']}
x_variables = ['WA', 'SA', 'NT']

# TEST 2 - FALSE
constraints = [('T', 'V'), ('WA', 'NT'), ('WA', 'SA'), ('NT', 'WA'), ('NT', 'Q'), ('NT', 'SA'), ('SA', 'WA'),
               ('SA', 'NT'), ('SA', 'Q'), ('SA', 'NSW'), ('SA', 'V'), ('Q', 'NT'), ('Q', 'SA'), ('Q', 'NSW'),
               ('NSW', 'Q'), ('NSW', 'SA'), ('NSW', 'V'), ('V', 'SA'), ('V', 'NSW'), ('V', 'T')]
domain = {'WA': ['R'], 'SA': ['R', 'G', 'B'], 'NT': ['R', 'G', 'B'], 'Q': ['G'], 'NSW': ['R', 'G', 'B'],
          'V': ['R', 'G', 'B'], 'T': ['R', 'G', 'B']}
x_variables = ['WA', 'SA', 'NT', 'T', 'Q', 'NSW', 'V']
"""
constraints = []
domain = {}
x_variables = []


def arc_consistency3():
    while len(constraints) != 0:
        print("constraints\n", constraints)
        current_i = constraints.pop(0)[0]
        current_j = constraints.pop(0)[1]
        print(current_i, "-", current_j)
        if revise((current_i, current_j)):
            print(domain)
            if len(domain[current_i]) == 0:
                return False
            for x_k in neighbours(current_i, current_j):
                print(x_k)
                constraints.append((current_j, current_i))
                constraints.append((x_k[1], current_i))
    return True


def revise(my_tuple):
    revised = False
    values_x_i = domain.get(my_tuple[0])
    values_x_j = domain.get(my_tuple[1])
    common_elements = [value for value in values_x_i if value in values_x_j]
    if len(common_elements) != 0:
        for i in common_elements:
            domain[my_tuple[0]].remove(i)
        revised = True
    return revised


def neighbours(x_i, x_j):
    neighbour_list = x_variables.copy()
    neighbour_list.remove(x_i)
    neighbour_list.remove(x_j)
    return list(zip([x_i], neighbour_list))


print(arc_consistency3())
