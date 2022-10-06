set terminal pdf
set termoption enhanced
set datafile separator "\t"
set output "plotRemoves.pdf"

set title "time in ns for different removes- linear vs constant"

set key left top

set xlabel "n"
set ylabel "time (ns)"


plot "data.dat" using 1:2 with linespoints title "constant avg", \
     "data.dat" using 1:4 with linespoints title "linear avg"