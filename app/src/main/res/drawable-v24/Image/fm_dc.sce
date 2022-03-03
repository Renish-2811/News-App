fs = 2e3;
t=0:1/fs:0.1;
Ac=1;
Am=1;
fc=160;
fm=40;
Vc=Ac*cos(((2*%pi)*fc)*t);
Vm=Am*sin(((2*%pi)*fm)*t);
m=8;
Vfm=Ac*cos((((2*%pi)*fc)*t)+m*Am*sin(((2*%pi)*fm)*t));

subplot(311);
plot(t,Vm)
title("Modulating Signal")
subplot(312);
plot(t,Vc);
title("Carrier signal")
subplot(313);
plot(t,Vfm)
title("Frequency modulationg signal")
