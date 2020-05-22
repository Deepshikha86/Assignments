Map<String, Integer> missingDate(TreeMap<String, Integer> dateAndValue) {
        if (dateAndValue.size() == 1 || dateAndValue.isEmpty()) return dateAndValue;
        String[] dates = dateAndValue.keySet().toArray(new String[0]);

        String curr = nextDate(dates[0]);
        while (!curr.equals(dates[dates.length - 1])) {
            String prevDate = prevDate(curr);
            String nextDate = dateAndValue.ceilingKey(curr);
            dateAndValue.put(curr, (dateAndValue.get(prevDate) + dateAndValue.get(nextDate)) / 2);
            curr = nextDate(curr);
        }
        return dateAndValue;
    }

    String nextDate(String date) {
        LocalDate nextDate = LocalDate.parse(date).plusDays(1);
        return nextDate.toString();
    }

    String prevDate(String date) {
        LocalDate prevDate = LocalDate.parse(date).minusDays(1);
        return prevDate.toString();
    }