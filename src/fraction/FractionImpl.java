package fraction;

public class FractionImpl implements Fraction {
    /**
     * Parameters are the <em>numerator</em> and the <em>denominator</em>.
     * Normalize the fraction as you create it.
     * For instance, if the parameters are <pre>(8, -12)</pre>, create a <pre>Fraction</pre> with numerator
     * <pre>-2</pre> and denominator <pre>3</pre>.
     *
     * The constructor should throw an <pre>ArithmeticException</pre> if the denominator is zero.
     *
     * @param numerator
     * @param denominator
     */
    private int numerator;
    private int denominator;
    public FractionImpl(int numerator, int denominator) {
        // TODO
        //this.denominator = denominator;

        int gcd = 0;
        if (denominator == 0){
            throw new ArithmeticException("number is not divisible by 0");
        }else{
            gcd = gcd(numerator,denominator);
            numerator /= gcd;
            denominator /= gcd;
            if (denominator<0){
                numerator = -numerator;
                denominator = Math.abs(denominator);
            }
            this.numerator = numerator;
            this.denominator = denominator;


        }






    }


    /**
     * The parameter is the numerator and <pre>1</pre> is the implicit denominator.
     *
     * @param wholeNumber representing the numerator
     */
    public FractionImpl(int wholeNumber) {
        // TODO
        this.numerator = wholeNumber;
        this.denominator = 1;
    }

    /**
     * The parameter is a <pre>String</pre> containing either a whole number, such as `5` or `-3`, or a fraction,
     * such as "8/-12".
     * Allow blanks around (but not within) integers.
     * The constructor should throw an <pre>ArithmeticException</pre>
     * if given a string representing a fraction whose denominator is zero.
     * <p>
     * You may find it helpful to look at the available String API methods in the Java API.
     *
     * @param fraction the string representation of the fraction
     */
    public FractionImpl(String fraction) {
        // TODO
        if (fraction.length() >1){
            String[] var = fraction.split("/");
            int i =1;
            for (String ele : var){
                if (i==1){
                    this.numerator = Integer.parseInt(ele);
                    i+=1;
                }
                else{
                    if (Integer.parseInt(ele)==0){
                        throw new ArithmeticException("Exception");
                    }else{
                        this.denominator = Integer.parseInt(ele);
                    }
                }

            }
            if (this.denominator ==0){
                FractionImpl  abc = new FractionImpl(this.numerator);
                this.numerator = abc.numerator;
                this.denominator = abc.denominator;
            }

            int gcd = gcd(this.numerator,this.denominator);
            if (this.denominator !=1){
                this.numerator /= gcd;
                this.denominator /= gcd;

            }

            if (this.denominator<0){
                this.numerator = 0-numerator;
                this.denominator = Math.abs(denominator);
            }
        }else{
            this.numerator = Integer.parseInt(fraction);
            this.denominator = 1;
        }




    }
    public static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        return gcd(q, p % q);
    }



    /**
     * @inheritDoc
     */
    @Override
    public Fraction add(Fraction f) {

        int sumNumerator = ((this.numerator*((FractionImpl) f).denominator)+(this.denominator*((FractionImpl) f).numerator));
        int sumDenominator = (this.denominator*(((FractionImpl) f).denominator));
        return new FractionImpl(sumNumerator,sumDenominator);

    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction subtract(Fraction f) {
        int sumNumerator = ((this.numerator*((FractionImpl) f).denominator)-(this.denominator*((FractionImpl) f).numerator));
        int sumDenominator = (this.denominator*(((FractionImpl) f).numerator));
        return new FractionImpl(sumNumerator,sumDenominator);

        //return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction multiply(Fraction f) {
        int mulNumerator = this.numerator*(((FractionImpl) f).numerator);
        int mulDenominator = (this.denominator*(((FractionImpl) f).denominator));
        return new FractionImpl(mulNumerator,mulDenominator);
        //return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction divide(Fraction f) {
        int divNumerator = this.numerator*(((FractionImpl) f).denominator);
        int divDenominator = (this.denominator*(((FractionImpl) f).numerator));
        return new FractionImpl(divNumerator,divDenominator);
        // return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction abs() {

        this.numerator = Math.abs(this.numerator);
        this.denominator = Math.abs(this.denominator);

        return new FractionImpl(this.numerator,this.denominator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction negate() {
        if (this.numerator<0){
            this.numerator = Math.abs(this.numerator);
        }else{
            this.numerator = 0-this.numerator;
        }
        if (this.denominator<0){
            this.denominator = Math.abs(this.denominator);
        }else{
            this.denominator = 0-this.denominator;
        }
        return new FractionImpl(this.numerator, this.denominator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * @inheritDoc
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Fraction){
            return super.equals(obj);
        }else{
            return false;
        }

    }

    /**
     * @inheritDoc
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction inverse() {
        int tempNumerator = this.numerator;
        int tempDenominator = this.denominator;
        this.numerator = tempDenominator;
        this.denominator = tempNumerator;
        return new FractionImpl(this.numerator, this.denominator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public int compareTo(Fraction o) {
        int thisNumerator = this.numerator;
        int thisDenominator = this.denominator;
        int oNumerator = ((FractionImpl)o).numerator;
        int oDenominator = ((FractionImpl)o).denominator;
        float thisValue = (float)thisNumerator/(float)thisDenominator;
        float oValue = (float)oNumerator/(float)oDenominator;
        if (thisValue ==0){
            return 0;
        }if (thisValue>oValue){
            return 1;
        }else {
            return -1;
        }
        //return 0;
    }

    /**
     * @inheritDoc
     */
    @Override
    public String toString() {
        if (this.numerator !=0){

            if (this.denominator ==1){
                return String.valueOf(this.numerator);

            }}
        return String.valueOf(this.numerator) + "/" + String.valueOf(this.denominator);
    }
}