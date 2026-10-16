
clear; clc;

A = hilb(10);
epsilon = eps;
bound = epsilon * cond(A,2);

fprintf('epsilon * cond(A) = %.4e\n', bound);

for t = 1:10
    xt = randn(10,1);
    b = A * xt;

    % Without pivoting
    [L1,U1] = lunp(A);
    y1 = L1 \ b;
    xc1 = U1 \ y1;

    % With partial pivoting
    [L2,U2,P] = lupp(A);
    y2 = L2 \ (P*b);
    xc2 = U2 \ y2;

    % Relative residuals
    r1 = norm(b-A*xc1,2)/(norm(A,2)*norm(xc1,2));
    r2 = norm(b-A*xc2,2)/(norm(A,2)*norm(xc2,2));

    % Relative errors
    e1 = norm(xc1-xt,2)/norm(xt,2);
    e2 = norm(xc2-xt,2)/norm(xt,2);

    fprintf('%2d  GENP: residual %.3e, error %.3e | GEPP: residual %.3e, error %.3e\n', ...
        t, r1, e1, r2, e2);
end
