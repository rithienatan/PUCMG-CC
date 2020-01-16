# x mapeado em $s1
.text
.globl teste
teste:

addi $8, $zero, 0x1001
sll $8, $8, 16 # valor do adress para acessar a memória armazenado em $t0

lw $16, 0($8) # load de x para $s0
lw $17, 4($8) # load de z para $s1

nop # sll $zero, $zero, 0

add $9, $zero, 3 # $t1 = 0 + 3
sll $9, $9, 16
add $9, $9, 103392 # $9 = 300000

sub $18, $16, $17 # $s2 = 100000 - 200000
add $18, $18, $9 # $s2 = $s2 + 300000

sw $18, 8($8) # salva o resultado de $s2 em y

.data
x: .word 100000
z: .word 200000
y: .word 0 # será sobrescrita após a excução do programa