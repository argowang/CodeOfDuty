    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() == 0) {
            return new ArrayList<>();
        }

        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.start,o2.start);
            }
        });

        for (int i = 1; i < intervals.size(); i++) {
            // could be merged
            Interval currInterval = intervals.get(i);
            Interval prevInterval = intervals.get(i-1);
            if (currInterval.start <= prevInterval.end) {
                prevInterval.end = Math.max(currInterval.end, prevInterval.end);
                intervals.remove(i--);
            }
        }

        return intervals;
    }
