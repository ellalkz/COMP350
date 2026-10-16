
function [L,U] = lunp(A)
% LU factorization without pivoting
n = size(A,1);

for k = 1:n-1
    i = k+1:n;
    A(i,k) = A(i,k)/A(k,k);
    A(i,i) = A(i,i) - A(i,k)*A(k,i);
end

L = tril(A,-1) + eye(n);
U = triu(A);
