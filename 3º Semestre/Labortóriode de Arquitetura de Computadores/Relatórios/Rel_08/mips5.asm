# x mapeado em $s1
.text
.globl teste
teste:

addi $8, $zero, 0x1001
sll $8, $8, 16 # valor do adress para acessar a memória armazenado em $t0

lw $16, 0($8) # load de x para $s0
lw $17, 4($8) # load de z para $s1

nop # sll $zero, $zero, 0

sll $9, $16, 7 # $t1 = $s0 * 128
sub $9, $9, $16 # $t1 = $t1 - $s0
sll $10, $17, 6 # $t2 = $s1 * 64
add $10, $10, $17 # $t2 = $t2 + $s1
sub $18, $9, $10 # $s2 = $t1 - $t2
addi $18, $18, 1 # $s2 = $s2 + 1

sw $18, 8($8) # salva o resultado de $s2 em y

.data
x: .word 5
z: .word 7
y: .word 0 # será sobrescrita após a excução do programa
