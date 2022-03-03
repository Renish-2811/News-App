Em = 10;
Ec = 10;
fm = 20;
fc = 200;
fs = 20e3;
t = 0:1/fs:1;
Vm = Em*sin(2*%pi*fm*t);
Vc = Ec*sin(2*%pi*fc*t);
Dsbsc = Ec.*sin(2*%pi*fc*t).*Em.*sin(2*%pi*fm*t).*cos(2*%pi*fc*t)
H = iir(7,'lp','butt',[fc/fs,0],[.1,.1]);
    num = coeff(H(2));
    den = coeff(H(3));
    num = num(length(num):-1:1);
    den = den(length(den):-1:1);
Lsb = filter(num,den,Dsbsc);
    subplot(4,1,1)
    plot(Vm)
    title('Modulating Signal')
    subplot(4,1,2)
    plot(Vc)
    title('Carrier Signal')
    subplot(4,1,3)
    plot(Lsb);
    title('SSB AM Signal')
    
rec = 2.*cos(2*%pi*fc*t).*Lsb

    H = iir(7,'lp','butt',[fc/fs,0],[.1,.1]);
    num = coeff(H(2));
    den = coeff(H(3));
    num = num(length(num):-1:1);
    den = den(length(den):-1:1);
    y = filter(num,den,rec);
